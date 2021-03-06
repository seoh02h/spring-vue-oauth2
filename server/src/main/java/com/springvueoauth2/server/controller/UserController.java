package com.springvueoauth2.server.controller;

import com.springvueoauth2.server.form.UserForm;
import com.springvueoauth2.server.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.security.Principal;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Api(value = "User", tags = {"User"})
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

  private final UserService service;

  @SneakyThrows
  @ApiOperation("일반 사용자 등록")
  @PostMapping("/users/signup")
  public UserForm.Output.Get addUser(@RequestBody UserForm.Input.Add in) {
    return service.addUser(in);
  }

  @SneakyThrows
  @ApiOperation("관리자 등록")
  @PostMapping("/users/signup/admin")
  public ResponseEntity addAdmin(@RequestBody UserForm.Input.Add in) {
    return new ResponseEntity(service.addAdmin(in), null, HttpStatus.CREATED);
  }

  @SneakyThrows
  @PreAuthorize("hasRole('ADMIN')")
  @ApiOperation("사용자 목록 조회")
  @GetMapping("/users")
  public ResponseEntity getAll() {
    return new ResponseEntity(service.getAll(), null, HttpStatus.OK);
  }

  @SneakyThrows
  @ApiOperation("로그인 사용자 조회")
  @GetMapping("/users/me")
  public ResponseEntity get(Principal principal) {
    return new ResponseEntity(service.getMe(principal), null, HttpStatus.OK);
  }

  @SneakyThrows
  @ApiOperation("사용자 수정")
  @PutMapping("/users/{userId}")
  public ResponseEntity modify(@PathVariable Long userId, @RequestBody UserForm.Input.Modify in) {
    return new ResponseEntity(service.modify(userId, in), null, HttpStatus.OK);
  }

  @SneakyThrows
  @ApiOperation("아이디 중복확인")
  @GetMapping("/users/duplicate")
  public ResponseEntity duplicate(String loginId) {
    return new ResponseEntity(service.duplicate(loginId), null, HttpStatus.OK);
  }

}
