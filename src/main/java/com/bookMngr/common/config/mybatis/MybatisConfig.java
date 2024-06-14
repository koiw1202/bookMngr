package com.bookMngr.common.config.mybatis;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.List;

@Configuration
@RequiredArgsConstructor
@MapperScan(value = "com.bookMngr.common.mybatis.mapper")
public class MybatisConfig {

    @Value("${mybatis.type-aliases-package}")
    private String typeAliasesPackage;

    @Value("${mybatis.mapper-locations}")
    private List<String> mapperLocations;

    @Value("${mybatis.configuration.map-underscore-to-camel-case}")
    private boolean MapUnderscoreToCamelCase;

    @Value("${mybatis.configuration.call-setters-on-nulls}")
    private boolean callSettersOnNulls;

    @Value("${mybatis.configuration.jdbc-type-for-null}")
    private JdbcType jdbcTypeForNull;

    private final EntityManagerFactory entityManagerFactory ;

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setDataSource(dataSource);

        sessionFactory.setMapperLocations(resolver.getResources(mapperLocations.get(0)));
        sessionFactory.setTypeAliasesPackage(typeAliasesPackage);

        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(MapUnderscoreToCamelCase);
        configuration.setCallSettersOnNulls(callSettersOnNulls);
        configuration.setJdbcTypeForNull(jdbcTypeForNull);
        sessionFactory.setConfiguration(configuration);

        return sessionFactory.getObject();
    }


    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception{
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    @Bean
    public ChainedTransactionManager transactionManager(DataSource dataSource){

        // JPA transactionManager
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);

        // MYBATIS transactionManager
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);

        // creates chained transaction manager
        ChainedTransactionManager transactionManager = new ChainedTransactionManager(jpaTransactionManager, dataSourceTransactionManager);

        return transactionManager;

    }

}