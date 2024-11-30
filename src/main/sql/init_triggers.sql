-- Создаем функцию проверки соответствия отдела компании
CREATE OR REPLACE FUNCTION check_department_belongs_to_company()
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.department_id IS NOT NULL THEN
        -- Проверяем, что отдел принадлежит указанной компании
        IF NOT EXISTS (
            SELECT 1
            FROM department
            WHERE department.id = NEW.department_id AND department.company_id = NEW.company_id
        ) THEN
            RAISE EXCEPTION 'Department does not belong to the specified company';
        END IF;
    END IF;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Создаем триггер для таблицы contact
CREATE TRIGGER validate_contact_department
BEFORE INSERT OR UPDATE ON contact
FOR EACH ROW
EXECUTE FUNCTION check_department_belongs_to_company();
