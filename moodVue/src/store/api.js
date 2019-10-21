// const ip = 'http://127.0.0.1:8080/dev'
const ip = '/dev'

const login = ip + '/user/login'
const register = ip + '/user/register'
const showmood = ip + '/user/essays'
const clickagree = ip + '/user/agree'
const comment = ip + '/user/comment'
const postcomment = ip + '/user/postcomment'
const postessay = ip + '/user/postessay'
const getessaycount = ip + '/user/getessaycount'
const getuserinfo = ip + '/user/info'
const getvisitor = ip +'/user/visitor'
const getcontacts = ip + '/message/contacts'
const getmsgdata = ip + '/message/:msgType'
const getfriends = ip + '/user/friends'
const getfollow = ip + '/user/follow'
const getfollowid = ip + '/user/followId'
const getfollowlist = ip + '/user/follow/list'
const getheat10 = ip + '/essay/top'
const addfollow = ip + '/add/follow'
const verifycontent = ip + '/verify/content'
const getverifycontent = ip + '/verify/content/list'
const addfriend = ip + '/add/friend'
const getuser = ip + '/user/infoAll'
const checkpwd = ip + '/user/pwd'

export default {
  login:login,
  register: register,
  showmood: showmood,
  clickagree: clickagree,
  comment:comment,
  postcomment: postcomment,
  postessay: postessay,
  getessaycount: getessaycount,
  getuserinfo: getuserinfo,
  getvisitor: getvisitor,
  getcontacts: getcontacts,
  ip: ip,
  getmsgdata:getmsgdata,
  getfriends:getfriends,
  getfollow:getfollow,
  getfollowid: getfollowid,
  getfollowlist: getfollowlist,
  getheat10: getheat10,
  addfollow: addfollow,
  verifycontent: verifycontent,
  getverifycontent: getverifycontent,
  addfriend:addfriend,
  getuser: getuser,
  checkpwd: checkpwd

}
