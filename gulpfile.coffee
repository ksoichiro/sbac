gulpFilter = require 'gulp-filter'
gutil = require 'gulp-util'
uglify = require 'gulp-uglify'
bowerSrc = require 'gulp-bower-src'
sourcemaps = require 'gulp-sourcemaps'
coffee = require 'gulp-coffee'
less = require 'gulp-less'
cssmin = require 'gulp-minify-css'
gulp = require 'gulp'

paths =
    less:
        files: ['src/main/resources/stylesheets/*.less']
        root: 'src/main/resources/stylesheets'
    coffee:
        files: ['src/main/resources/javascripts/*.coffee']
        root: 'src/main/resources/javascripts'
    dest: './src/main/resources/static/'

gulp.task 'less', ->
    gulp.src paths.less.files
        .pipe less()
        .pipe cssmin {root: paths.less.root}
        .pipe gulp.dest paths.dest + 'css'

gulp.task 'coffee', ->
    gulp.src paths.coffee.files
        .pipe coffee()
        .pipe uglify()
        .pipe gulp.dest paths.dest + 'js'

gulp.task 'bower-files', ->
    filter = gulpFilter(["**/*.js", "!**/*.min.js"])
    bowerSrc()
        .pipe sourcemaps.init()
        .pipe filter
        .pipe uglify()
        .pipe filter.restore()
        .pipe sourcemaps.write "./"
        .pipe gulp.dest paths.dest + 'lib'

    filter = gulpFilter(["**/*.min.css", "fonts/*"])
    bowerSrc()
        .pipe sourcemaps.init()
        .pipe filter
        .pipe filter.restore()
        .pipe sourcemaps.write "./"
        .pipe gulp.dest paths.dest + 'lib'

gulp.task 'watch', ->
    gulp.watch paths.less.files, ['less']
    gulp.watch paths.coffee.files, ['coffee']

gulp.task 'build', ['less', 'coffee', 'bower-files'], ->
