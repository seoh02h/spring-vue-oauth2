package com.springvueoauth2.server.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public class UserForm {

  public static class Input {

    @Data
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Add {

      @ApiModelProperty(value = "로그인아이디")
      private String loginId;

      @ApiModelProperty(value = "이름")
      private String name;

      @ApiModelProperty(value = "비밀번호")
      private String password;

    }
  }

  public static class Output {

    @Data
    @Builder
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetAll {

      @ApiModelProperty(value = "로그인아이디")
      private String loginId;

      @ApiModelProperty(value = "이름")
      private String name;

    }
  }

}
