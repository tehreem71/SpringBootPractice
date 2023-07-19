package com.practice.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Model class to receive and store a simple string message
 */
public @Data
@NoArgsConstructor
@RequiredArgsConstructor class SpringBootModel
{
  @NonNull
  private String message;
}
