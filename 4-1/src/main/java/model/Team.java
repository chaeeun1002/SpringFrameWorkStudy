package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//DB의 team테이블과 매핑하는 클래스 -> @Entity
//DB의 무슨 테이블과 매핑해야 하는지 DB의 테이블 이름을 지정해야 함. -> @Table(name="테이블이름")
@Entity
@Table(name="team")
public class Team {
	private Integer team_id;
	private String name;
	@Id //테이블의 기본키임을 선언
	public Integer getTeam_id() {
		return team_id;
	}
	public void setTeam_id(Integer team_id) {
		this.team_id = team_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
