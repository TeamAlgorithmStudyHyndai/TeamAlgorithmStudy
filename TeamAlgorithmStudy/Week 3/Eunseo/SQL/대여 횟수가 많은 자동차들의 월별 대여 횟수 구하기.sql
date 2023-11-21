select to_number(month) as month,car_id,records from (
    select to_char(a.start_date,'mm') as month, a.car_id, count(*) as records
        from car_rental_company_rental_history a inner join (
            select car_id from car_rental_company_rental_history
            where to_char(start_date,'yymm')>='2208'
             and to_char(start_date,'yymm')<='2210'
            group by car_id
            having count(*) >=5
            ) b
        on a.car_id = b.car_id
    where to_char(a.start_date,'yymm')>='2208'and to_char(a.start_date,'yymm')<='2210'
    group by to_char(a.start_date,'mm'), a.car_id
    having count(*) > 0)
order by month,car_id desc
