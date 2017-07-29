package com.edufabricio.server.repository;

import com.edufabricio.server.jpa.MessageReceived;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageReceivedRepository extends JpaRepository<MessageReceived, Long> {

}
