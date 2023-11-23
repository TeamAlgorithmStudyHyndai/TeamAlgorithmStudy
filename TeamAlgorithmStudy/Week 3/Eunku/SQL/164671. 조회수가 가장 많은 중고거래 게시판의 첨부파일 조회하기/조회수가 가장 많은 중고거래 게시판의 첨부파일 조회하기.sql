-- 코드를 입력하세요
select '/home/grep/src/' || U.BOARD_ID ||'/' || U.FILE_ID || U.FILE_NAME || U.FILE_EXT as file_path
from
USED_GOODS_FILE U
where U.BOARD_ID = (select A.BOARD_ID
    from
    (SELECT
        *
    FROM
        USED_GOODS_BOARD
    order by views desc) A
    where rownum=1)
order by file_id desc