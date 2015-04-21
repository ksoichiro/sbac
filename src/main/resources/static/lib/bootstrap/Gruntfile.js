module.exports=function(s){"use strict";s.util.linefeed="\n",RegExp.quote=function(s){return s.replace(/[-\\^$*+?.()|[\]{}]/g,"\\$&")};var e=require("fs"),t=require("path"),c=require("npm-shrinkwrap"),r=require("./grunt/bs-glyphicons-data-generator.js"),i=require("./grunt/bs-lessdoc-parser.js"),o=function(){var s=t.join(__dirname,"less/variables.less"),c=e.readFileSync(s,{encoding:"utf8"}),r=new i(c);return{sections:r.parseFile()}},n=require("./grunt/bs-raw-files-generator.js"),a=require("./grunt/bs-commonjs-generator.js"),d=s.file.readJSON("./grunt/configBridge.json",{encoding:"utf8"});Object.keys(d.paths).forEach(function(s){d.paths[s].forEach(function(s,e,c){c[e]=t.join("./docs/assets",s)})}),s.initConfig({pkg:s.file.readJSON("package.json"),banner:'/*!\n * Bootstrap v<%= pkg.version %> (<%= pkg.homepage %>)\n * Copyright 2011-<%= grunt.template.today("yyyy") %> <%= pkg.author %>\n * Licensed under <%= pkg.license.type %> (<%= pkg.license.url %>)\n */\n',jqueryCheck:d.config.jqueryCheck.join("\n"),jqueryVersionCheck:d.config.jqueryVersionCheck.join("\n"),clean:{dist:"dist",docs:"docs/dist"},jshint:{options:{jshintrc:"js/.jshintrc"},grunt:{options:{jshintrc:"grunt/.jshintrc"},src:["Gruntfile.js","grunt/*.js"]},core:{src:"js/*.js"},test:{options:{jshintrc:"js/tests/unit/.jshintrc"},src:"js/tests/unit/*.js"},assets:{src:["docs/assets/js/src/*.js","docs/assets/js/*.js","!docs/assets/js/*.min.js"]}},jscs:{options:{config:"js/.jscsrc"},grunt:{src:"<%= jshint.grunt.src %>"},core:{src:"<%= jshint.core.src %>"},test:{src:"<%= jshint.test.src %>"},assets:{options:{requireCamelCaseOrUpperCaseIdentifiers:null},src:"<%= jshint.assets.src %>"}},concat:{options:{banner:"<%= banner %>\n<%= jqueryCheck %>\n<%= jqueryVersionCheck %>",stripBanners:!1},bootstrap:{src:["js/transition.js","js/alert.js","js/button.js","js/carousel.js","js/collapse.js","js/dropdown.js","js/modal.js","js/tooltip.js","js/popover.js","js/scrollspy.js","js/tab.js","js/affix.js"],dest:"dist/js/<%= pkg.name %>.js"}},uglify:{options:{preserveComments:"some"},core:{src:"<%= concat.bootstrap.dest %>",dest:"dist/js/<%= pkg.name %>.min.js"},customize:{src:d.paths.customizerJs,dest:"docs/assets/js/customize.min.js"},docsJs:{src:d.paths.docsJs,dest:"docs/assets/js/docs.min.js"}},qunit:{options:{inject:"js/tests/unit/phantom.js"},files:"js/tests/index.html"},less:{compileCore:{options:{strictMath:!0,sourceMap:!0,outputSourceFiles:!0,sourceMapURL:"<%= pkg.name %>.css.map",sourceMapFilename:"dist/css/<%= pkg.name %>.css.map"},src:"less/bootstrap.less",dest:"dist/css/<%= pkg.name %>.css"},compileTheme:{options:{strictMath:!0,sourceMap:!0,outputSourceFiles:!0,sourceMapURL:"<%= pkg.name %>-theme.css.map",sourceMapFilename:"dist/css/<%= pkg.name %>-theme.css.map"},src:"less/theme.less",dest:"dist/css/<%= pkg.name %>-theme.css"}},autoprefixer:{options:{browsers:d.config.autoprefixerBrowsers},core:{options:{map:!0},src:"dist/css/<%= pkg.name %>.css"},theme:{options:{map:!0},src:"dist/css/<%= pkg.name %>-theme.css"},docs:{src:["docs/assets/css/anchor.css","docs/assets/css/src/docs.css"]},examples:{expand:!0,cwd:"docs/examples/",src:["**/*.css"],dest:"docs/examples/"}},csslint:{options:{csslintrc:"less/.csslintrc"},dist:["dist/css/bootstrap.css","dist/css/bootstrap-theme.css"],examples:["docs/examples/**/*.css"],docs:{options:{ids:!1,"overqualified-elements":!1},src:"docs/assets/css/src/docs.css"}},cssmin:{options:{compatibility:"ie8",keepSpecialComments:"*",advanced:!1},minifyCore:{src:"dist/css/<%= pkg.name %>.css",dest:"dist/css/<%= pkg.name %>.min.css"},minifyTheme:{src:"dist/css/<%= pkg.name %>-theme.css",dest:"dist/css/<%= pkg.name %>-theme.min.css"},docs:{src:["docs/assets/css/src/pygments-manni.css","docs/assets/css/src/anchor.css","docs/assets/css/src/docs.css"],dest:"docs/assets/css/docs.min.css"}},usebanner:{options:{position:"top",banner:"<%= banner %>"},files:{src:"dist/css/*.css"}},csscomb:{options:{config:"less/.csscomb.json"},dist:{expand:!0,cwd:"dist/css/",src:["*.css","!*.min.css"],dest:"dist/css/"},examples:{expand:!0,cwd:"docs/examples/",src:"**/*.css",dest:"docs/examples/"},docs:{src:"docs/assets/css/src/docs.css",dest:"docs/assets/css/src/docs.css"}},copy:{fonts:{expand:!0,src:"fonts/*",dest:"dist/"},docs:{expand:!0,cwd:"dist/",src:["**/*"],dest:"docs/dist/"}},connect:{server:{options:{port:3e3,base:"."}}},jekyll:{options:{config:"_config.yml"},docs:{},github:{options:{raw:"github: true"}}},jade:{options:{pretty:!0,data:o},customizerVars:{src:"docs/_jade/customizer-variables.jade",dest:"docs/_includes/customizer-variables.html"},customizerNav:{src:"docs/_jade/customizer-nav.jade",dest:"docs/_includes/nav/customize.html"}},htmllint:{options:{ignore:['Attribute "autocomplete" not allowed on element "button" at this point.','Attribute "autocomplete" not allowed on element "input" at this point.','Element "img" is missing required attribute "src".']},src:"_gh_pages/**/*.html"},watch:{src:{files:"<%= jshint.core.src %>",tasks:["jshint:src","qunit","concat"]},test:{files:"<%= jshint.test.src %>",tasks:["jshint:test","qunit"]},less:{files:"less/**/*.less",tasks:"less"}},sed:{versionNumber:{pattern:function(){var e=s.option("oldver");return e?RegExp.quote(e):e}(),replacement:s.option("newver"),recursive:!0}},"saucelabs-qunit":{all:{options:{build:process.env.TRAVIS_JOB_ID,throttled:10,maxRetries:3,maxPollRetries:4,urls:["http://127.0.0.1:3000/js/tests/index.html?hidepassed"],browsers:s.file.readYAML("grunt/sauce_browsers.yml")}}},exec:{npmUpdate:{command:"npm update"}},compress:{main:{options:{archive:"bootstrap-<%= pkg.version %>-dist.zip",mode:"zip",level:9,pretty:!0},files:[{expand:!0,cwd:"dist/",src:["**"],dest:"bootstrap-<%= pkg.version %>-dist"}]}}}),require("load-grunt-tasks")(s,{scope:"devDependencies"}),require("time-grunt")(s),s.registerTask("validate-html",["jekyll:docs","htmllint"]);var p=function(s){return!process.env.TWBS_TEST||process.env.TWBS_TEST===s},l=function(s){return void 0===s||"0"!==s},m=[];p("core")&&"twbs-savage/bootstrap"!==process.env.TRAVIS_REPO_SLUG&&(m=m.concat(["dist-css","dist-js","csslint:dist","test-js","docs"])),p("validate-html")&&l(process.env.TWBS_DO_VALIDATOR)&&m.push("validate-html"),"undefined"!=typeof process.env.SAUCE_ACCESS_KEY&&p("sauce-js-unit")&&l(process.env.TWBS_DO_SAUCE)&&(m.push("connect"),m.push("saucelabs-qunit")),s.registerTask("test",m),s.registerTask("test-js",["jshint:core","jshint:test","jshint:grunt","jscs:core","jscs:test","jscs:grunt","qunit"]),s.registerTask("dist-js",["concat","uglify:core","commonjs"]),s.registerTask("less-compile",["less:compileCore","less:compileTheme"]),s.registerTask("dist-css",["less-compile","autoprefixer:core","autoprefixer:theme","usebanner","csscomb:dist","cssmin:minifyCore","cssmin:minifyTheme"]),s.registerTask("dist",["clean:dist","dist-css","copy:fonts","dist-js"]),s.registerTask("default",["clean:dist","copy:fonts","test"]),s.registerTask("change-version-number","sed"),s.registerTask("build-glyphicons-data",function(){r.call(this,s)}),s.registerTask("build-customizer",["build-customizer-html","build-raw-files"]),s.registerTask("build-customizer-html","jade"),s.registerTask("build-raw-files","Add scripts/less files to customizer.",function(){var e=s.template.process("<%= banner %>");n(s,e)}),s.registerTask("commonjs","Generate CommonJS entrypoint module in dist dir.",function(){var e=s.config.get("concat.bootstrap.src"),t="dist/js/npm.js";a(s,e,t)}),s.registerTask("docs-css",["autoprefixer:docs","autoprefixer:examples","csscomb:docs","csscomb:examples","cssmin:docs"]),s.registerTask("lint-docs-css",["csslint:docs","csslint:examples"]),s.registerTask("docs-js",["uglify:docsJs","uglify:customize"]),s.registerTask("lint-docs-js",["jshint:assets","jscs:assets"]),s.registerTask("docs",["docs-css","lint-docs-css","docs-js","lint-docs-js","clean:docs","copy:docs","build-glyphicons-data","build-customizer"]),s.registerTask("prep-release",["jekyll:github","compress"]),s.registerTask("update-shrinkwrap",["exec:npmUpdate","_update-shrinkwrap"]),s.registerTask("_update-shrinkwrap",function(){var t=this.async();c({dev:!0,dirname:__dirname},function(c){c&&s.fail.warn(c);var r="test-infra/npm-shrinkwrap.json";e.renameSync("npm-shrinkwrap.json",r),s.log.writeln("File "+r.cyan+" updated."),t()})})};
//# sourceMappingURL=../bootstrap/Gruntfile.js.map