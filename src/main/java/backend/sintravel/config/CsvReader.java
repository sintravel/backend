//package backend.sintravel.config;
//
//import backend.sintravel.domain.place.model.dto.PlaceDto;
//import backend.sintravel.domain.place.model.entity.Place;
//import lombok.RequiredArgsConstructor;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DefaultFieldSet;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.batch.item.file.transform.LineTokenizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//
//@Configuration
//@RequiredArgsConstructor
//public class CsvReader {
//
//    @Bean
//    public FlatFileItemReader<CsvLine> csvFileItemReader() {
//        /* file read */
//        FlatFileItemReader<CsvLine> flatFileItemReader = new FlatFileItemReader<>();
//        flatFileItemReader.setResource(new ClassPathResource("/csv/place1.csv"));
//        flatFileItemReader.setLinesToSkip(1); // header line skip
//        flatFileItemReader.setEncoding("UTF-8"); // encoding
//
//        /* read하는 데이터를 내부적으로 LineMapper을 통해 Mapping */
//        DefaultLineMapper<CsvLine> defaultLineMapper = new DefaultLineMapper<>();
//
//
////        /* delimitedLineTokenizer : setNames를 통해 각각의 데이터의 이름 설정 */
////        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
//////        delimitedLineTokenizer.setNames("place_id", "place_name", "category_name", "category_group_code", "category_group_name", "phone", "address_name", "road_address_name", "x", "y", "place_url", "wheelchair", "animal", "keyword", "evalnum", "rate");
////        delimitedLineTokenizer.setNames("line");
////        defaultLineMapper.setLineTokenizer(delimitedLineTokenizer);
//
//        /* beanWrapperFieldSetMapper : Tokenizer에서 가지고온 데이터들을 VO로 바인드하는 역할 */
//        BeanWrapperFieldSetMapper<CsvLine> beanWrapperFieldSetMapper = new BeanWrapperFieldSetMapper<>();
//        beanWrapperFieldSetMapper.setTargetType(CsvLine.class);
//
//        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);
//
//        /* lineMapper 지정 */
//        flatFileItemReader.setLineMapper(defaultLineMapper);
//
//        return flatFileItemReader;
//    }
//}
