package system.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity // This tells Hibernate to make a table out of this class
@Table(name = "SCHOLARSHIPS")
@DynamicUpdate
@Data
public class Scholarships extends Base {

    @Column(name = "COUNTRY_NAME")
	private String countryName;

    @Column(name="EDUCATION")
    private String educationLevel;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    private String status;



}

