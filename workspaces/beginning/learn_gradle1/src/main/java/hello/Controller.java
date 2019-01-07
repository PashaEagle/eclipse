package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller 
{

    private static final String template = "Hello, %s! Your work is %s";
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping("/hi")
    public Hello hi(@RequestParam(value="name", required=false, defaultValue="World") String name, @RequestParam(value="job", required=false, defaultValue="worker") String job) 
    {
        return new Hello(counter.incrementAndGet(), String.format(template, name, job));
    }
}