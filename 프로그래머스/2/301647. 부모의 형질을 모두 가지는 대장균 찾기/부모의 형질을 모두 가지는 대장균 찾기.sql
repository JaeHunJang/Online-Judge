-- 코드를 작성해주세요
SELECT ed.id, ed.genotype, ped.genotype parent_genotype
FROM ecoli_data ed
JOIN ecoli_data ped ON ed.parent_id = ped.id
WHERE (ed.genotype & ped.genotype) = ped.genotype
ORDER BY ed.id