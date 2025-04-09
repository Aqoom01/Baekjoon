SELECT count(id) as 'FISH_COUNT'
FROM fish_info join fish_name_info on fish_info.fish_type = fish_name_info.fish_type
WHERE fish_name_info.fish_name = 'BASS' or fish_name_info.fish_name = 'SNAPPER'