package uk.co.redsoft.springboot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.MDC;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CorrelationIdFilterTest {

    private MockHttpServletRequest httpServletRequest = new MockHttpServletRequest();
    private MockHttpServletResponse httpServletResponse = new MockHttpServletResponse();
    private FilterChain filterChain = new MockFilterChain();
    private CorrelationIdFilter correlationIdFilter = new CorrelationIdFilter();

    @Test
    public void correlationIdFromHeaderIsStoredInMdc() throws ServletException, IOException {
        httpServletRequest.addHeader("X-Correlation_ID", "12345");
        correlationIdFilter.doFilter(httpServletRequest, httpServletResponse, filterChain);
        assertThat(MDC.get("correlationId")).isEqualTo("12345");
    }

    @Test
    public void mdcIsEmptyIfNoCorrelationHeaderInRequest() throws ServletException, IOException {
        correlationIdFilter.doFilter(httpServletRequest, httpServletResponse, filterChain);
        assertThat(MDC.get("correlationId")).isEqualTo(null);
    }
}