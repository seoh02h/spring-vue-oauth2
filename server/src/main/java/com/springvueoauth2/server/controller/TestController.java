package com.springvueoauth2.server.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(value = "Test", tags = {"Test"})
@RequestMapping(value = "/api")
public class TestController {

  @SneakyThrows
  @ApiOperation("커넥션 테스트")
  @GetMapping("/test")
  public String test(){
    return "test";
  }

}
