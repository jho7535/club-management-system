package com.sw.club_management_system.dao;

import com.sw.club_management_system.domain.Membership;
import com.sw.club_management_system.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MembershipDao {

    private final JdbcTemplate jdbcTemplate;

    // RowMapper: ResultSet 데이터를 Membership 객체로 매핑
    private final RowMapper<Membership> membershipRowMapper = (rs, rowNum) -> {
        Membership membership = new Membership();
        membership.setStudentNumber(rs.getInt("student_number")); // 학생 번호
        membership.setClubId(rs.getInt("club_id"));               // 클럽 ID
        membership.setRole(rs.getString("role"));                 // 역할
        return membership;
    };

    // RowMapper: ResultSet 데이터를 User 객체로 매핑
    private final RowMapper<User> userRowMapper = (rs, rowNum) -> {
        User user = new User();
        user.setStudentNumber(rs.getInt("student_number")); // 학생 번호
        user.setEmail(rs.getString("email"));               // 이메일
        user.setPassword(rs.getString("password"));         // 비밀번호
        user.setDepartment(rs.getString("department"));     // 학과
        return user;
    };

    // 모든 멤버십 조회
    public List<Membership> findAll() {
        String sql = "SELECT * FROM membership";
        return jdbcTemplate.query(sql, membershipRowMapper);
    }

    // 특정 학생의 모든 멤버십 조회
    public List<Membership> findByStudentNumber(Integer studentNumber) {
        String sql = "SELECT * FROM membership WHERE student_number = ?";
        return jdbcTemplate.query(sql, membershipRowMapper, studentNumber);
    }

    // 특정 클럽의 모든 멤버십 조회
    public List<Membership> findByClubId(Integer clubId) {
        String sql = "SELECT * FROM membership WHERE club_id = ?";
        return jdbcTemplate.query(sql, membershipRowMapper, clubId);
    }

    // 특정 학생이 특정 클럽에 속한 멤버십 조회
    public Optional<Membership> findByStudentNumberAndClubId(Integer studentNumber, Integer clubId) {
        String sql = "SELECT * FROM membership WHERE student_number = ? AND club_id = ?";
        return jdbcTemplate.query(sql, membershipRowMapper, studentNumber, clubId)
                .stream()
                .findFirst(); // 첫 번째 결과 반환 (Optional)
    }

    // 특정 클럽의 모든 멤버 조회 (User 정보를 함께 반환)
    public List<User> findMembersByClubId(Integer clubId) {
        String sql = """
        SELECT u.student_number, u.email, u.password, u.department
        FROM membership m
        JOIN user u ON m.student_number = u.student_number
        WHERE m.club_id = ?
    """;

        return jdbcTemplate.query(sql, userRowMapper, clubId);
    }


    // 새로운 멤버십 추가
    public int insert(Membership membership) {
        String sql = "INSERT INTO membership (student_number, club_id, role) VALUES (?, ?, ?)";
        return jdbcTemplate.update(
                sql,
                membership.getStudentNumber(), // 학생 번호
                membership.getClubId(),        // 클럽 ID
                membership.getRole()           // 역할
        );
    }

    // 멤버십 정보 업데이트
    public int update(Membership membership) {
        String sql = "UPDATE membership SET role = ? WHERE student_number = ? AND club_id = ?";
        return jdbcTemplate.update(
                sql,
                membership.getRole(),           // 수정할 역할
                membership.getStudentNumber(),  // 조건: 학생 번호
                membership.getClubId()          // 조건: 클럽 ID
        );
    }

    // 특정 학생의 특정 클럽 멤버십 삭제
    public int deleteByStudentAndClub(Integer studentNumber, Integer clubId) {
        String sql = "DELETE FROM membership WHERE student_number = ? AND club_id = ?";
        return jdbcTemplate.update(sql, studentNumber, clubId);
    }

    // 특정 클럽의 모든 멤버십 삭제
    public int deleteByClubId(Integer clubId) {
        String sql = "DELETE FROM membership WHERE club_id = ?";
        return jdbcTemplate.update(sql, clubId);
    }
}
