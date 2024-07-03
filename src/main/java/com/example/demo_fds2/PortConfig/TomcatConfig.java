// package com.example.demo_fds2.PortConfig;

// import org.apache.catalina.connector.Connector;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
// import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.util.StringUtils;

// import com.example.demo_fds2.TransactionEnginee.NetworkCfg.NetworkCfg;
// import com.example.demo_fds2.TransactionEnginee.NetworkCfg.NetworkCfgRepository;

// import java.util.List;

// @Configuration
// public class TomcatConfig {

//     @Autowired
//     private NetworkCfgRepository networkCfgRepository;

//     @Bean
//     public ServletWebServerFactory servletContainer() {
//         TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
//         tomcat.setPort(8080);        
//         tomcat.addAdditionalTomcatConnectors(createAdditionalConnectors());

//         return tomcat;
//     }

//     private Connector[] createAdditionalConnectors() {
//         List<NetworkCfg> networkCfgs = networkCfgRepository.findAll();
//         Connector[] connectors = new Connector[networkCfgs.size()];

//         for (int i = 0; i < networkCfgs.size(); i++) {
//             NetworkCfg networkCfg = networkCfgs.get(i);
//             if (StringUtils.hasText(networkCfg.getPortNumber())) {
//                 Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//                 connector.setPort(Integer.parseInt(networkCfg.getPortNumber()));
//                 connectors[i] = connector;
//                 System.out.println("Setting additional port number: " + networkCfg.getPortNumber());
//             }
//         }
//         return connectors;
//     }
// }
