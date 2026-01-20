# 🏢 Club Management System (CMS)

> **동아리 운영의 효율성을 극대화하기 위한 통합 관리 플랫폼**
> 본 프로젝트는 동아리 회장 및 운영진을 역임했던 경험을 바탕으로, 동아리 회원 관리, 일정 조립, 서류 승인 프로세스를 자동화하기 위해 설계되었습니다.

---

## 📖 목차

1. [프로젝트 소개](https://www.google.com/search?q=%23-%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EC%86%8C%EA%B0%9C)
2. [주요 기능](https://www.google.com/search?q=%23-%EC%A3%BC%EC%9A%94-%EA%B8%B0%EB%8A%A5)
3. [기술 스택](https://www.google.com/search?q=%23-%EA%B8%B0%EC%88%A0-%EC%8A%A4%ED%83%9D)
4. [시스템 아키텍처](https://www.google.com/search?q=%23-%EC%8B%9C%EC%8A%A4%ED%85%9C-%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98)
5. [데이터베이스 설계](https://www.google.com/search?q=%23-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-%EC%84%A4%EA%B3%84)
6. [시작 가이드](https://www.google.com/search?q=%23-%EC%8B%9C%EC%9E%91-%EA%B0%80%EC%9D%B4%EB%93%9C)
7. [커밋 컨벤션](https://www.google.com/search?q=%23-%EC%BB%A4%EB%B0%8B-%EC%BB%A8%EB%B2%A4%EC%85%98)

---

## 🌟 프로젝트 소개

* **목적**: 80명 규모의 대형 학술 동아리 운영 시 발생하는 행정적 번거로움 해결
* **핵심 가치**: 데이터 정규화를 통한 무결성 확보, 비즈니스 로직의 서비스 계층 분리, 직관적인 UI 제공
* **진행 상태**: 백엔드 핵심 도메인 로직(DAO, Service, Controller) 개발 완료 및 Thymeleaf를 이용한 뷰 구현 중

---

## ✨ 주요 기능

### 👤 회원 및 권한 관리 (`User`, `Admin`)

* 일반 회원 가입 및 로그인 프로세스
* 관리자 전용 대시보드를 통한 회원 상태 관리
* `AuthorizationService`를 통한 역할 기반 접근 제어

### 🛡️ 동아리 관리 (`Club`, `Membership`)

* 동아리 생성, 수정 및 상세 정보 조회
* 회원별 동아리 가입 상태 및 권한(Membership) 관리

### 📅 일정 및 참여 관리 (`Schedule`, `Participation`)

* 동아리 공식 일정 생성 및 수정
* 일정별 회원 참여 여부 추적 및 관리

### 📄 서류 결재 시스템 (`Document`, `DocumentStatus`)

* 동아리 내 각종 보고서 및 서류 제출
* 결재 상태(대기, 승인, 반려) 실시간 추적 및 관리

---

## 🛠 기술 스택

### Backend

* **Language**: Java 17
* **Framework**: Spring Boot 3.x
* **Build Tool**: Gradle
* **Database Access**: DAO (Data Access Object) Pattern 기반 데이터 처리

### Frontend

* **Template Engine**: Thymeleaf
* **Style**: HTML5, CSS3

### Database

* **RDBMS**: MySQL / PostgreSQL (SQLD 자격증 취득 역량 기반 정규화 설계 적용)

---

## 🏗 시스템 아키텍처

본 프로젝트는 유지보수와 확장성을 위해 **Layered Architecture**를 준수합니다.

* **Controller**: `ViewController`를 통해 웹 요청을 처리하고 적절한 HTML 템플릿 반환
* **Service**: 비즈니스 로직 처리 및 트랜잭션 경계 설정
* **DAO**: 데이터베이스 물리 계층에 직접 접근하여 CRUD 수행
* **Domain/DTO**: 데이터 객체 및 계층 간 데이터 전송 객체 관리

---

## 🗄 데이터베이스 설계

데이터의 일관성을 위해 3차 정규화까지 마친 설계를 적용했습니다. 상세 다이어그램은 `/docs` 디렉토리에서 확인할 수 있습니다.

* **ER-Diagram**: `docs/ER-Diagram.png`
* **Relation Schema**: `docs/Relation_Schema(Normalized).png`

---

## 🚀 시작 가이드

### 요구 사항

* Java 17 이상
* MySQL 8.0 이상

### 설치 및 실행

```bash
# 저장소 복제
git clone https://github.com/your-repo/club-management-system.git

# 디렉토리 이동
cd club-management-system

# 빌드 및 실행
./gradlew bootRun

```

---

## 🤝 커밋 컨벤션 (Commit Convention)

일관된 프로젝트 히스토리 관리를 위해 아래 규칙을 준수합니다.

| 태그 | 의미 |
| --- | --- |
| **feat** | 새로운 기능 추가 |
| **fix** | 버그 수정 |
| **docs** | 문서 수정 (README, 주석 등) |
| **style** | 코드 의미에 영향을 주지 않는 수정 (포맷팅 등) |
| **refactor** | 코드 리팩토링 |
| **test** | 테스트 코드 추가 및 수정 |
| **chore** | 기타 작업 (파일 이동, 단순 설정 변경 등) |
| **build** | 빌드 관련 파일 수정 (build.gradle 등) |
| **ci** | CI 설정 파일 및 스크립트 수정 (GitHub Actions 등) |

**형식**: `<태그>: <메시지>` (예: `feat: 회원 가입 API 구현`)

---

## 👨‍💻 개발자 정보

* **역할**: 팀 리더 및 백엔드 개발 총괄
* **관련 프로젝트 경험**:
* 2024 +AI 메이커톤 최우수상 수상
* Barrier-free 스마트 키오스크 'inclukiosk' MSA 기반 백엔드 개발
* C 기반 비동기 I/O 로드밸런서 구축 경험

