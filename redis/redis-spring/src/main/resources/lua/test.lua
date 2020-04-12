local flag = tonumber(KEYS[1]);
local flag1 = tonumber(ARGV[1]);
print(flag1);
if(flag > 0 and flag1 > 100)
then
    return 1;
else
    return 0;
end