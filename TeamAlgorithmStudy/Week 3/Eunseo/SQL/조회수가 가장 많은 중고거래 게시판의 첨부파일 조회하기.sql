SELECT '/home/grep/src/' || a.board_id || '/' || b.FILE_ID || FILE_NAME || FILE_EXT as FILE_PATH
from USED_GOODS_BOARD  a inner join USED_GOODS_FILE b
on a.BOARD_ID = b.BOARD_ID
where a.VIEWS =
(select Max(views)
from USED_GOODS_BOARD)
order by b.FILE_ID desc;
