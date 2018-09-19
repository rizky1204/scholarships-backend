package system.domain;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "USER_SCHOLARSHIPS")
@DynamicUpdate
@Data
public class UserScholarships {

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERS")
    private Users users;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCHOLARSHIPS")
    private Scholarships scholarships;

    @Column(name = "STATUS")
    private String status;
}
