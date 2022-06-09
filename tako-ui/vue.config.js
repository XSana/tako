const {defineConfig} = require('@vue/cli-service')
module.exports = defineConfig({
    transpileDependencies: [
        /node_modules[/\\\\\\\\](@antv|)[/\\\\\\\\]/,
        /node_modules[/\\\\\\\\](lodash|)[/\\\\\\\\]/,
        /node_modules[/\\\\\\\\](hex-rgb|)[/\\\\\\\\]/,
        /node_modules[/\\\\\\\\](d3-dispatch|)[/\\\\\\\\]/,
        /node_modules[/\\\\\\\\](d3-force|)[/\\\\\\\\]/,
        /node_modules[/\\\\\\\\](regl|)[/\\\\\\\\]/,
        /node_modules[/\\\\\\\\](ml-matrix|)[/\\\\\\\\]/
    ],
    // 禁止生成Source Map
    productionSourceMap: false,
    // 根路径
    publicPath: "/",

})

