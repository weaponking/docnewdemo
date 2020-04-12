local lock = redis.call("setnx",KEYS[1],ARGV[1]);
if(lock > 0)
then
	redis.call("expire",KEYS[1],tonumber(ARGV[2]));
	return redis.call("get",KEYS[1]);
else
	return "-1";
end