// package com.example.demo_fds2.PortConfig;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
// import org.springframework.util.StringUtils;

// import com.example.demo_fds2.TransactionEnginee.Endpoint.Endpoint;
// import com.example.demo_fds2.TransactionEnginee.Endpoint.EndpointRepository;

// import javax.servlet.*;
// import javax.servlet.http.HttpServletRequest;
// import java.io.IOException;

// @Component
// public class PortValidationFilter implements Filter {

//     @Autowired
//     private EndpointRepository endpointRepository;

//     @Override
//     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//             throws IOException, ServletException {
//         HttpServletRequest httpRequest = (HttpServletRequest) request;
//         String requestUrl = httpRequest.getRequestURI();
//         int requestPort = request.getLocalPort();

//         // Tambahkan logging untuk debugging
//         System.out.println("Request URL: " + requestUrl);
//         System.out.println("Request Port: " + requestPort);

//         Endpoint endpointConfig = endpointRepository.findByUrl(requestUrl);

//         if (endpointConfig != null) {
//             System.out.println("EndpointConfig found: " + endpointConfig);
//             if (endpointConfig.getConfig() != null) {
//                 System.out.println("Config found: " + endpointConfig.getConfig());
//                 if (StringUtils.hasText(endpointConfig.getConfig().getPortNumber())) {
//                     int expectedPort = Integer.parseInt(endpointConfig.getConfig().getPortNumber());

//                     if (requestPort != expectedPort) {
//                         response.getWriter().write("Forbidden: Invalid port for endpoint");
//                         response.getWriter().flush();
//                         return;
//                     }
//                 }
//             }
//         }

//         chain.doFilter(request, response);
//     }
// }
