use sqldb;

select * from usertbl;
select * from buytbl;

select * from usertbl where name="김경호";

-- 1970년 이후에 출생하고 신장이 182이상 사람의 아이디와 이름 조회
SELECT 
    name, userID
FROM
    usertbl
WHERE
    birthYear >= 1970 AND height >= 182;
    
-- 키가 180~183인 사람의 이름과 키를 조회
select name, height
from usertbl
-- where height >= 180 and height <= 183; 
where height between 180 and 183;

-- 지역이 경남, 전남, 경북인 사람 이름,지역명 조회
select name, addr
from usertbl
where addr in ("경남","전남","경북");

-- 성이 김씨인 사람들의 이름과 키 조회
select name, height
from usertbl
where name like '김__';

-- 김경호보다 키가 크거나 같은 사람의 이름과 키를 조회
select name, height
from usertbl
where height >=(
select height
from usertbl
where name='김경호');

-- 지역이 '경남'인 사람의 키보다 키가 크거나 같은 사람의 이름과 키 조회
select name, height, addr
from usertbl
where height >= any(
	select height
    from usertbl
    where addr='경남'
);

-- 가입일이 빠른 순서
select name, mdate
from usertbl
order by mdate desc;

-- usertbl에서 회원들이 거주지역이 어딘인지 출력
select distinct addr
from usertbl;

-- 먼저 가입한 순으로 4명만 출력
select name, mdate
from usertbl
order by mdate asc
limit 1,3;

-- 테이블 복사
-- pk, fk같은 제약조건들은 복사 안됨
create table buytbl2(
	select * from buytbl
);

-- 구매 테이블에서 사용자가 구매한 물품의 개수를 출력
select userId, sum(amount)
from buytbl
group by userId;

-- 구매 테이블에서 각 사용자별 구매액의 총합을 출력
select userId, sum(price*amount)
from buytbl
group by userId;