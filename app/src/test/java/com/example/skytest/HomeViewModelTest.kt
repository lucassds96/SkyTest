package com.example.skytest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.skytest.model.Movies
import com.example.skytest.repository.HomeRepositoryHelper
import com.example.skytest.ui.home.HomeViewModel
import com.example.skytest.utils.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var apiHelper: HomeRepositoryHelper

    @Mock
    private lateinit var apiMoviesObserver: Observer<Resource<List<Movies>>>

    @Test
    fun givenServerResponse200_whenFetch_shouldReturnSuccess() {
        testCoroutineRule.runBlockingTest {
            doReturn(emptyList<Movies>())
                .`when`(apiHelper)
                .getMovies()
            val viewModel = HomeViewModel(apiHelper)
            viewModel.getMovies().observeForever(apiMoviesObserver)
            verify(apiHelper).getMovies()
            verify(apiMoviesObserver).onChanged(Resource.success(emptyList()))
            viewModel.getMovies().removeObserver(apiMoviesObserver)
        }
    }

    @Test
    fun givenServerResponseError_whenFetch_shouldReturnError() {
        testCoroutineRule.runBlockingTest {
            val errorMessage = "Error Message For You"
            doThrow(RuntimeException(errorMessage))
                .`when`(apiHelper)
                .getMovies()
            val viewModel = HomeViewModel(apiHelper)
            viewModel.getMovies().observeForever(apiMoviesObserver)
            verify(apiHelper).getMovies()
            verify(apiMoviesObserver).onChanged(
                Resource.error(
                    RuntimeException(errorMessage).toString(),
                    null
                )
            )
            viewModel.getMovies().removeObserver(apiMoviesObserver)
        }
    }
}