-- 집계함수, sum(), count(), count(distinct), max(), min(), avg()

-- 전체 구매자가 구매한 물품 개수의 평균
select avg(amount)
from buytbl;

-- 각 사용자별로 한번 구매시 물건을 평균 몇 개 구매하는지 조회
select userID, avg(amount)
from buytbl
group by userID;

-- 가장 큰 키와 가장 작은 키의 회원 이름과 키를 출력
select name, height
from usertbl
where height = (
	select max(height) from usertbl
) or height = (
	select min(height) from usertbl
);

-- 사용자별 총 구매금액이 1000 이상인 사용자만 출력
select userID, sum(price*amount)
from buytbl
group by userID
having sum(price*amount) >= 1000;

-- blob
CREATE DATABASE moviedb;
USE moviedb;

CREATE TABLE movieTBL (
	movie_id INT,
    movie_title VARCHAR(30),
    movie_script LONGTEXT,
    movie_film LONGBLOB
) DEFAULT CHARSET = utf8mb4;

-- 데이터를 입력
insert into movietbl values(1, '쉰들러 리스트', 
	load_file('C:\sql\Schindler.txt'),
    load_file('C:\sql\Schindler.mp4')
);

select * from movietbl;

delete from movieTBL;
-- 환경설정이 안되었기 때문에 정상적으로 동작하지 않음
-- 설정 필요

select movie_film
from movietbl
where movie_id=1
into dumpfile 'C:/sql/video.output.mp4';

-- join
use sqldb;

-- 구매 테이블에서 JYP라는 아이디를 가진 사람이 구매한 물건을
-- 발송하기 위해서 이름과 주소가 필요
-- 두 테이블을 결합해서 결과
select buytbl.userID, name, addr
from buytbl
	inner join usertbl
    on buytbl.userID = usertbl.userID
where buytbl.userID = 'JYP';


-- 간단한 예제
use sqldb;
create table stdtbl(
	std_name varchar(10) not null primary key,
    std_addr varchar(4) not null
);

create table clubtbl(
	club_name varchar(10) not null primary key,
    club_room varchar(4) not null
);

-- 학생 동아리 테이블 생성
create table stdclubtbl(
	num int auto_increment not null primary key,
	std_name varchar(10) not null,
    club_nstdclubtblame varchar(10) not null,
    foreign key(std_name) references stdtbl(std_name),
    foreign key(club_name) references clubtbl(club_name)
);

insert into stdtbl values ("김범수","경남");
insert into stdtbl values ("성시경","서울");
insert into stdtbl values ("조용필","경기");
insert into stdtbl values ("은지원","경북");
insert into stdtbl values ("바비킴","서울");

insert into clubtbl values ("수영","101호");
insert into clubtbl values ("바둑","102호");
insert into clubtbl values ("축구","103호");
insert into clubtbl values ("봉사","104호");

INSERT INTO stdclubtbl VALUES (NULL, "김범수","바둑");
INSERT INTO stdclubtbl VALUES (NULL, "김범수","축구");
INSERT INTO stdclubtbl VALUES (NULL, "조용필","축구");
INSERT INTO stdclubtbl VALUES (NULL, "은지원","축구");
INSERT INTO stdclubtbl VALUES (NULL, "은지원","봉사");
INSERT INTO stdclubtbl VALUES (NULL, "바비킴","봉사");

-- 학생 기준으로 학생이름, 지역, 가입한 동아리, 동아리 방번호 출력
select s.std_name, s.std_addr, sc.club_name, c.club_room
from stdtbl s
	inner join stdclubtbl sc
    on s.std_name = sc.std_name
    inner join clubtbl c
    on sc.club_name = c.club_name
order by s.std_name;

-- usertbl과 buytbl을 이용
-- 전체 회원의 구매기록 조회
-- 구매 기록이 없는 회원도 출력
select u.userID, u.name, b.prodName, u.addr
from usertbl u
	left outer join buytbl b
    on u.userID = b.userID;
    
-- 한번도 구매한 적이 없는 회원의 목록 출력
select u.userID, u.name, b.prodName, u.addr
from usertbl u
	left outer join buytbl b
    on u.userID = b.userID
where b.prodName is null;

-- 간단한 문제 9개
-- DROP DATABASE IF EXISTS sqldb;
-- CREATE DATABASE IF NOT EXISTS sqldb;
USE sqldb;

DROP TABLE IF EXISTS emp,
                     dept,
                     locations,
                     salgrade;

CREATE TABLE SALGRADE ( 
  GRADE INT PRIMARY KEY,
  LOSAL INT,
  HISAL INT
);

INSERT INTO SALGRADE VALUES (1,700,1200);
INSERT INTO SALGRADE VALUES (2,1201,1400);
INSERT INTO SALGRADE VALUES (3,1401,2000);
INSERT INTO SALGRADE VALUES (4,2001,3000);
INSERT INTO SALGRADE VALUES (5,3001,9999);

CREATE TABLE LOCATIONS (
  LOC_CODE CHAR(2) ,
  CITY  VARCHAR(20),
  PRIMARY KEY (LOC_CODE)
);
INSERT INTO LOCATIONS VALUES ('A1','SEOUL');
INSERT INTO LOCATIONS VALUES ('B1','DALLAS');
INSERT INTO LOCATIONS VALUES ('C1','CHICAGO');
INSERT INTO LOCATIONS VALUES ('D1','BOSTON');


CREATE TABLE DEPT (
  DEPTNO INT PRIMARY KEY,
  DNAME VARCHAR(20),
  LOC_CODE CHAR(2),
  FOREIGN KEY (LOC_CODE) REFERENCES LOCATIONS(LOC_CODE)
);

INSERT INTO DEPT VALUES (10,'ACCOUNTING','A1');
INSERT INTO DEPT VALUES (20,'RESEARCH','B1');
INSERT INTO DEPT VALUES (30,'SALES','C1');
INSERT INTO DEPT VALUES (40,'OPERATIONS','A1');
INSERT INTO DEPT VALUES (50,'INSA',null);


CREATE TABLE EMP (
  EMPNO INT PRIMARY KEY,
  ENAME VARCHAR(14),
  JOB VARCHAR(30),
  MGR INT,
  HIREDATE DATE,
  SAL INT,
  COMM INT,
  DEPTNO INT,
  FOREIGN KEY (DEPTNO) REFERENCES DEPT(DEPTNO)
);

INSERT INTO EMP VALUES
(7369,'SMITH','CLERK',7902,'1980-12-17',800,null,20);
INSERT INTO EMP VALUES
(7499,'ALLEN','SALESMAN',7698,'1981-02-20',1600,300,30);
INSERT INTO EMP VALUES
(7521,'WARD','SALESMAN',7698,'1981-02-22',1250,200,30);
INSERT INTO EMP VALUES
(7566,'JONES','MANAGER',7839,'1981-04-02',2975,30,20);
INSERT INTO EMP VALUES
(7654,'MARTIN','SALESMAN',7698,'1981-09-28',1250,300,30);
INSERT INTO EMP VALUES
(7698,'BLAKE','MANAGER',7839,'1981-04-01',2850,null,30);
INSERT INTO EMP VALUES
(7782,'CLARK','MANAGER',7839,'1981-06-01',2450,null,10);
INSERT INTO EMP VALUES
(7788,'SCOTT','ANALYST',7566,'1982-10-09',3000,null,20);
INSERT INTO EMP VALUES
(7839,'KING','PRESIDENT',null,'1981-11-17',5000,3500,10);
INSERT INTO EMP VALUES
(7844,'TURNER','SALESMAN',7698,'1981-09-08',1500,0,30);
INSERT INTO EMP VALUES
(7876,'ADAMS','CLERK',7788,'1983-01-12',1100,null,null);
INSERT INTO EMP VALUES
(7900,'JAMES','CLERK',7698,'1981-10-03',950,null,30);
INSERT INTO EMP VALUES
(7902,'FORD','ANALYST',7566,'1981-10-3',3000,null,20);
INSERT INTO EMP VALUES
(7934,'MILLER','CLERK',7782,'1982-01-23',1300,null,10);




DROP TABLE IF EXISTS course1,
                     course2;

create table course1 (
name varchar(15),
phone varchar(20),
age int
) DEFAULT CHARSET=utf8;

create table course2 (
name varchar(15),
phone varchar(20),
age int
) DEFAULT CHARSET=utf8;

insert into course1 values('둘리', '010-111-1111', 10);
insert into course1 values('또치', '010-222-2222', 11);
insert into course1 values('도우너', '010-333-3333', 12);
insert into course1 values('희동이', '010-444-4444', 6);

insert into course2 values('둘리', '010-111-1111', 10);
insert into course2 values('또치', '010-222-2222', 11);
insert into course2 values('토토로', '010-555-5555', 13);
insert into course2 values('짱구', '010-666-6666', 7);
insert into course2 values('듀크', '010-777-7777', 11);

-- 1. 30번 부서의 직무 별 급여의 평균을 파악하고자 합니다.
--    출력 컬럼 명: "직무", "급여 평균"    
--    연봉의 평균은 백 단위 까지만 나타냅니다.
select sub.JOB as '직무', TRUNCATE(CAST(avg(sub.SAL) AS signed integer), -2) as '급여 평균'
from
(select *
from emp e
where e.DEPTNO = 30) sub
group by sub.JOB;

-- 2. 근무 중인 직원이 4명 이상인 부서의 정보를 출력합니다.
--  출력 컬럼 명: "부서명", "직원 수"
select JOB, COUNT(*)
from emp
group by DEPTNO
having COUNT(*) >= 4;

-- 3. 직무 별(job) 급여의 합을 출력하고 마지막에 누적 집계도 출력합니다. 
-- 누적 집계를 출력하는 행의 급여의 합은 총합계를 출력합니다.
--    또한 금액에는 천단위마다 콤마(,)를 출력합니다.
--    출력 컬럼 명: "직무명", "급여의 합"
select COALESCE(JOB, "합계"), SUM(SAL)
from emp
group by JOB WITH ROLLUP;

-- 4. 이 회사에서 월급을 제일 많이 받는 사람의 이름과 월급 그리고 급여 등급을 출력하세요.
--    출력 컬럼 명:  "직원명", "급여", "급여 등급"
select ENAME, SAL, salgrade.GRADE
from emp
	join salgrade
    on emp.SAL between salgrade.LOSAL and salgrade.HISAL
where SAL = (
	select max(SAL)
    from emp
);

-- 5. 1981년에 입사한 직원들의 이름을 월급을 많이 받는 순으로 출력합니다. 급여는 sal + comm으로 계산하는데 comm 이 null인 경우에는 0으로 계산합니다. 또한 천 단위마다 ,를 붙이고 뒤에 '원' 을 붙여서  출력합니다. 
-- 출력 컬럼 명: "직원명", "급여"
select ENAME, SAL + ifnull(COMM, 0)
from emp
where date_format(HIREDATE,"%Y") <='1981'
order by SAL + ifnull(COMM, 0) desc;

-- 6. 입사한 년도가 1980년이면 'A'를 1981년이면 'B'를 1982년이면 'C'를 1983년이면 'D'로 그룹을 출력합니다.
--     출력 컬럼 명: "직원명", "입사년월일", "그룹"
--     입사년월일은 'XXXX년 XX월 XX일'로 표현합니다.
select ENAME, HIREDATE,
	case
		when date_format(HIREDATE,"%Y") = '1980'
        then "A"
        when date_format(HIREDATE,"%Y") = '1981'
        then "B"
        when date_format(HIREDATE,"%Y") = '1982'
        then "C"
        when date_format(HIREDATE,"%Y") = '1983'
        then "D"
	end as 'group'
from emp;

-- 7. 사원번호와 사원이름, 그리고 그 사원을 관리하는 관리자의 사원번호와 사원이름을 출력하되 각각의 컬럼명을 "사원 사번",
--    "사원 이름", "관리자 사번", "관리자 이름"으로 출력하는데 관리자가 없는 직원은 제외합니다.
select e.EMPNO, e.ENAME, e.MGR, m.ENAME
from emp e
	join emp m
    on e.MGR = m.EMPNO;


-- 8. 'CHICAGO' 라는 도시에서 근무중인 직원의 사번, 성명 그리고 부서번호를 출력합니다.(JOIN 구문으로 해결)
select empno, ename, DEPTNO
from emp
where DEPTNO = (
select dept.DEPTNO
from locations
	join dept
    on locations.LOC_CODE = dept.LOC_CODE
where locations.CITY = "CHICAGO");

-- 9. 30번 부서의 직원들의 급여보다 많은 급여를 받는 직원들의 이름을 출력합니다. 
select ename, sal
from emp
where sal > ALL(
select sal
from emp
where DEPTNO = '30'
);