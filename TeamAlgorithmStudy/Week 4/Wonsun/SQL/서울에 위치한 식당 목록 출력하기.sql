-- REST_INFO와 REST_REVIEW 테이블에서 서울에 위치한 식당들의
-- 식당 ID, 식당 이름, 음식 종류, 즐겨찾기수, 주소, 리뷰 평균 점수를 조회하는 SQL문을 작성
-- 이때 리뷰 평균점수는 소수점 세 번째 자리에서 반올림  
-- 결과는 평균점수를 기준으로 내림차순 정렬
-- 평균점수가 같다면 즐겨찾기수를 기준으로 내림차순 정렬해주세요.
SELECT      a.rest_id
            ,b.rest_name
            ,b.food_type
            ,b.favorites
            ,b.address
            ,round(AVG(a.review_score),2) AS SCORE
FROM        rest_review A
JOIN        rest_info B 
ON          a.rest_id = b.rest_id
GROUP BY    a.rest_id, b.rest_name, b.food_type, b.favorites, b.address
HAVING      b.address LIKE '서울%'
ORDER BY    score DESC, b.favorites DESC
