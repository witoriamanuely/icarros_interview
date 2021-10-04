package br.com.br.consumingrest.test;


import br.com.br.consumingrest.ConsumingRestApplication;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest(classes = ConsumingRestApplication.class)
public abstract class AbstractTest<T>  {

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;


    @Autowired
    private MappingJackson2HttpMessageConverter converter;

    private MockMvc mockMvc;


    public void init(T resource) {

        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(resource)
                .setCustomArgumentResolvers(this.pageableArgumentResolver).setControllerAdvice()
                .setMessageConverters(this.converter, new ResourceHttpMessageConverter()).build();
    }

    public PageableHandlerMethodArgumentResolver getPagebleResolver() {
        return pageableArgumentResolver;
    }

    public MappingJackson2HttpMessageConverter getConverter() {
        return converter;
    }

    public MockMvc getMockMvc() {
        return mockMvc;
    }

}
