select *
from loainguyenlieu;

insert into loainguyenlieu(LOAINGUYENLIEU_ID, LOAINGUYENLIEU_NAME, LOAINGUYENLIEU_UNIT)
values("5", "Trứng", "Hộp");

insert into loainguyenlieu(LOAINGUYENLIEU_ID, LOAINGUYENLIEU_NAME, LOAINGUYENLIEU_UNIT)
values("6", "Nước", "Lít");

delete 
from loainguyenlieu
where LOAINGUYENLIEU_ID = 6;

update loainguyenlieu
set LOAINGUYENLIEU_UNIT = "Lít"
where LOAINGUYENLIEU_ID = 6;









