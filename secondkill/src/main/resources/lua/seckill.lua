local userId=KEYS[1];
local goodsId=KEYS[2];

local cntKey=goodsId.."_count";
local userExists=goodsId.."_"..userId;

local result1=redis.call("get",userExists);
if result1 and tonumber(result1) == 1 then
  return 2;
end


local num = redis.call("get",cntKey);
if num and tonumber(num) <=0 then
  return 0;
else
  redis.call("decr",cntKey);
  redis.call("set",userExists,1);
end

return 1;
