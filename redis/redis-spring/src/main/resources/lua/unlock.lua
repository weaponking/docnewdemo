local lockKey = redis.call("get",KEYS[1]);
local lockVal = ARGV[1];
if(lockKey == lockVal) then
	redis.call("del",KEYS[1]);
	return true;
else
	return false;
end