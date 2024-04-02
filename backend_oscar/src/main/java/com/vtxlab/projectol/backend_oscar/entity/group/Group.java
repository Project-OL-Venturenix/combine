package com.vtxlab.projectol.backend_oscar.entity.group;

import java.time.LocalDateTime;
import java.util.Set;
import com.vtxlab.projectol.backend_oscar.entity.event.Event;
import com.vtxlab.projectol.backend_oscar.entity.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "groups_")
public class Group {
  /*
   * userName and email must be unique
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "groups_id")
  private Long groupsId;

  private String name;
  private String status;
  private LocalDateTime createdDate;
  private Integer createdBy;
  private LocalDateTime updatedDate;
  private Integer updatedBy;


  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(joinColumns = @JoinColumn(name = "groups_id"))
  private Set<Event> events;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(joinColumns = @JoinColumn(name = "groups_id"))
  private Set<User> users;


}
