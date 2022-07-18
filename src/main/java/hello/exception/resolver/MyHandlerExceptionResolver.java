package hello.exception.resolver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        try {
            if (ex instanceof IllegalArgumentException) {
                log.info("IllegalArgumentException resolver to 400");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage()); //SC_BAD_REQUEST가 400임
                return new ModelAndView();
            }
            //IllegalArgumentException 이 발생하면
            //response.sendError(400) 를 호출해서 HTTP 상태 코드를 400으로 지정하고,
            // 빈 ModelAndView 를 반환

        } catch (IOException e) {
            log.error("resolver ex", e);
        }
        return null;
    }
}
