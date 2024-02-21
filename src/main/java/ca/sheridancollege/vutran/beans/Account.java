package ca.sheridancollege.vutran.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	private String gender;
	private boolean subscribe;
	@Enumerated(EnumType.STRING)
	private Country country;
	private String message;
}




/*
 * 
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "password": "secretpassword",
  "gender": "Male",
  "subscribe": true,
  "country": "CANADA",
  "message": "This is a test message."
}, 
{
  "name": "David Vu",
  "email": "dv@example.com",
  "password": "secretpassword",
  "gender": "Male",
  "subscribe": true,
  "country": "US",
  "message": "This is a test message."
}

*/
