define(["./core","./core/access","./css"],function(e,n){return e.each({Height:"height",Width:"width"},function(t,o){e.each({padding:"inner"+t,content:o,"":"outer"+t},function(c,i){e.fn[i]=function(i,r){var d=arguments.length&&(c||"boolean"!=typeof i),s=c||(i===!0||r===!0?"margin":"border");return n(this,function(n,o,c){var i;return e.isWindow(n)?n.document.documentElement["client"+t]:9===n.nodeType?(i=n.documentElement,Math.max(n.body["scroll"+t],i["scroll"+t],n.body["offset"+t],i["offset"+t],i["client"+t])):void 0===c?e.css(n,o,s):e.style(n,o,c,s)},o,d?i:void 0,d,null)}})}),e});
//# sourceMappingURL=../../jquery/src/dimensions.js.map