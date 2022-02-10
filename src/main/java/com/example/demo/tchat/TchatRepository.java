package com.example.demo.tchat;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TchatRepository extends JpaRepository<Tchat, Integer> {
}
