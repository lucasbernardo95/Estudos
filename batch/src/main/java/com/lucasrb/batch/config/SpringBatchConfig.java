package com.lucasrb.batch.config;

import com.lucasrb.batch.entity.Customer;
import com.lucasrb.batch.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class SpringBatchConfig {

    private JobBuilderFactory jobBuilderFactory;
    private StepBuilderFactory stepBuilderFactory;
    private CustomerRepository repository;

    @Bean
    public FlatFileItemReader<Customer> reader(){
        var itemReader = new FlatFileItemReader<Customer>();
        itemReader.setResource(new FileSystemResource("src/main/resources/customers.csv"));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());

        return itemReader;
    }

    private LineMapper<Customer> lineMapper() {
        var lineMapper = new DefaultLineMapper<Customer>();
        DelimitedLineTokenizer delimited = new DelimitedLineTokenizer();
        delimited.setDelimiter(",");
        delimited.setStrict(false);
        delimited.setNames("id", "firstName", "lastName", "email", "gender", "contactNo", "country", "dob");

        var fieldSetMapper = new BeanWrapperFieldSetMapper<Customer>();
        fieldSetMapper.setTargetType(Customer.class);

        lineMapper.setLineTokenizer(delimited);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }

    @Bean
    public CustomerProcessor processor(){
        return new CustomerProcessor();
    }

    @Bean
    public RepositoryItemWriter<Customer> writer(){
        var writer = new RepositoryItemWriter<Customer>();
        writer.setRepository(repository);
        writer.setMethodName("save");

        return writer;
    }

    @Bean
    public Step step1(){
        return stepBuilderFactory.get("csv-step")
                .<Customer, Customer>chunk(250)
                .reader(reader())
                .processor(processor())
                .writer(writer())
//                .taskExecutor(taskExecutor())
                .taskExecutor(taskExecutorThread())
                .build();
    }

    @Bean
    public Job runJob(){
        return jobBuilderFactory.get("importCustomers")
                .flow(step1()).end().build();
                //.next(step1())
    }
//
//    @Bean
//    public TaskExecutor taskExecutor(){
//        var asyncTaskExecutor = new SimpleAsyncTaskExecutor();
//        asyncTaskExecutor.setConcurrencyLimit(5);
//        return asyncTaskExecutor;
//    }

    @Bean
    public TaskExecutor taskExecutorThread(){
        var executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(250);
        executor.setThreadNamePrefix("Thread N:" );
        return executor;
    }
}
