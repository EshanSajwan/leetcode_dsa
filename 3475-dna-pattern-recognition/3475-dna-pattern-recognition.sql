# Write your MySQL query statement below
select 
    sample_id,
    dna_sequence,
    species,
    if( left(dna_sequence , 3) = 'ATG' , 1 , 0) as has_start,
    if( right(dna_sequence , 3) in ('TAA' , 'TAG' , 'TGA') , 1 , 0) as has_stop,
    if( dna_sequence like '%ATAT%', 1 , 0) as has_atat,
    if( dna_sequence like '%GGG%' , 1 , 0) as has_ggg
from Samples
order by sample_id;