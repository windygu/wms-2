module.exports = {
    entry: './main.ts',
    output: {
        path: __dirname + '/../site/web/js',
        filename: 'dddml-app.js'
    },
    resolve: {
        // Add `.ts` and `.tsx` as a resolvable extension.
        extensions: ['', '.ts', '.tsx', '.js']
    },
    module: {
        loaders: [
            {test: /\.tsx?$/, loader: 'ts-loader'},
            {
                test: /\.html$/,
                loader: "html"
            }
        ]
    }
};