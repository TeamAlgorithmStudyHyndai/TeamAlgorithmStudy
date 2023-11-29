-- PATIENT, DOCTOR 그리고 APPOINTMENT 테이블에서
-- 2022년 4월 13일 취소되지 않은 흉부외과(CS) 진료 예약 내역을 조회
-- 진료예약번호, 환자이름, 환자번호, 진료과코드, 의사이름, 진료예약일시 항목이 출력
-- a.apnt_no, p.pt_name, p.pt_no, a.mcdp_cd, d.dr_id, a.apnt_ymd
-- 결과는 진료예약일시를 기준으로 오름차순 정렬

SELECT      a.apnt_no
            ,p.pt_name
            ,p.pt_no
            ,a.mcdp_cd
            ,d.dr_name
            ,a.apnt_ymd
FROM        appointment a
JOIN        patient p
ON          p.pt_no = a.pt_no
JOIN        doctor d
ON          d.dr_id = a.mddr_id          
WHERE       a.apnt_cncl_yn = 'N'
and         (extract(year from a.apnt_ymd) = 2022 
             and extract(month from a.apnt_ymd) = 4
             and extract(day from a.apnt_ymd) = 13
            )
ORDER BY    a.apnt_ymd
