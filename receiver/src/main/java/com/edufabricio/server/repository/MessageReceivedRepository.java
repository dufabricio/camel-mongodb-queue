package com.edufabricio.server.repository;

import com.edufabricio.server.jpa.MessageReceived;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageReceivedRepository extends JpaRepository<MessageReceived, Long> {

}
