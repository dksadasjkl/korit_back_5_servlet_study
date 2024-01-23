package memo;

public class Download {
	
	/*
	 * MySQL 다운로드
	 */
	// https://dev.mysql.com/downloads/file/?id=526407 
	//	- > No thanks, just start my download.
	// 실행 -> full -> Execute -> LEgacy -> name : passward : root 
	
	// 파라미터 그룹 옵션
	// time - Asia/Seoul
	// char - utf8mb4 -> mb4 이모티콘
	// collation - utf8mb4_0900_ai_ci
	
	// 데이터베이스 생성 옵션
	// log_bin - log_bin_trust_function_creators - 1
	// 프리티어
	// 스토리지 자동 조정 -> 활성화 체크풀기
	// 퍼블릭 액세스 -> 예
	// db 파라미터 그룹 -> mysql
	// 자동 백업 x
	// 자동 업그레이드 x
	
	/*
	 * MySQL 
	 */
//	schemas -> use `db명` -> ctrl + enter
	// ` `: 테이블명, ' ' " " :값
	

	/*
	 * 정규화의 목적 -> 중복제거 
	 * 제 1 정규화 (1NF): 각 테이블의 모든 속성은 원자값(Atomic Value)을 가져야 합니다. 즉, 각 속성은 더 이상 분해할 수 없는 단일 값이어야 합니다.
		- 한칸에 하나씩
		제 2 정규화 (2NF): 테이블이 1NF이고, 기본 키에 완전 함수 종속(dependent)되어야 합니다. 즉, 기본 키 이외의 모든 컬럼은 기본 키 전체에 종속되어야 합니다.
		- table 주제에 맞게 짜야함.
		- 단점 : 테이블을 합쳐야함
		-  composite primary key에 종속된 컬럼을 빼는 행위 - 무조건 종속 되는 행위
		제 3 정규화 (3NF): 테이블이 2NF이고, 기본 키 이외의 모든 컬럼은 기본 키에 이행적으로 종속되지 않아야 합니다. 즉, 이행 종속(Transitive Dependency)이 없어야 합니다.
		- 
		BCNF (Boyce-Codd 정규형): 테이블이 3NF이고, 모든 결정자가 후보 키이어야 합니다. 이를 통해 이행 종속 문제를 해결합니다.

		제 4 정규화 (4NF): 테이블이 BCNF이고, 다치 종속(Multivalued Dependency)을 제거합니다.
	 */
	
	
}
