define(["../core","../manipulation"],function(e){function t(t,n){var o,d=e(n.createElement(t)).appendTo(n.body),a=window.getDefaultComputedStyle&&(o=window.getDefaultComputedStyle(d[0]))?o.display:e.css(d[0],"display");return d.detach(),a}function n(n){var a=document,r=d[n];return r||(r=t(n,a),"none"!==r&&r||(o=(o||e("<iframe frameborder='0' width='0' height='0'/>")).appendTo(a.documentElement),a=(o[0].contentWindow||o[0].contentDocument).document,a.write(),a.close(),r=t(n,a),o.detach()),d[n]=r),r}var o,d={};return n});
//# sourceMappingURL=../../../jquery/src/css/defaultDisplay.js.map