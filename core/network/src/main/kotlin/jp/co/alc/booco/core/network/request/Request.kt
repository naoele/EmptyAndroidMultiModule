package jp.co.alc.booco.core.network.request

interface Request {
    fun <R> get(): jp.co.alc.booco.core.common.result.Result<R>
    fun <T, R> post(body: T): jp.co.alc.booco.core.common.result.Result<R>
}