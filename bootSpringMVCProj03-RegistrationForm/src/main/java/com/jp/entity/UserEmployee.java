package com.jp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "USER_EMP_TAB")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class UserEmployee {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	@NonNull
	private String userName;
	@NonNull
	private String password;
	@NonNull
	private String email;
	@NonNull
	private String profession;
	

}
