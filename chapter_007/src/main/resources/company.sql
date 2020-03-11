SELECT person.name, company.name
FROM person
LEFT JOIN company ON
person.company_id = company.id
WHERE company_id!=5;

SELECT company.name, count(*)
FROM company
LEFT JOIN person
ON company.id=person.company_id
WHERE company.id=
(SELECT company_id FROM person GROUP BY company_id ORDER BY COUNT(*) DESC LIMIT 1)
GROUP BY company.name;