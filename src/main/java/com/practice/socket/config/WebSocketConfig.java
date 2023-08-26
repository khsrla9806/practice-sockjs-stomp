package com.practice.socket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        /* WebSocket 엔드포인트 설정 및 SockJS 사용 설정 */
        registry.addEndpoint("/websocket").setAllowedOriginPatterns("*").withSockJS();
    }

    /**
     *  /topic 을 구독하는 클라이언트에게 브로드캐스팅을 하고, /app 으로 송신할 수 있도록 설정
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        /* 메시지 브로커 설정:  Spring 에서 제공하는 내장 메모리 기반 브로커가 설정 */
        registry.enableSimpleBroker("/topic");

        /* 클라이언트에서 메시지 송신 시 사용하는 prefix 설정 */
        registry.setApplicationDestinationPrefixes("/app");
    }
}
